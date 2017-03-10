  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting r1 = read()
          # Emitting r1
          subl $4, %esp
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -8(%ebp), %esi
        movl %esi, -4(%ebp)
        # Emitting r2 = (5 + r1)
          # Emitting r2
          subl $4, %esp
          # Emitting (5 + r1)
            # Emitting 5
            movl $5, %esi
          pushl %esi
            # Emitting r1
            movl -4(%ebp), %esi
          movl -16(%ebp), %edx
          addl $4, %esp
          addl %esi, %edx
        movl %edx, -12(%ebp)
        # Emitting r1 = (r1 / r2)
          # Emitting r1
          movl -4(%ebp), %edi
          # Emitting (r1 / r2)
            # Emitting r1
            movl -4(%ebp), %edx
          pushl %edx
            # Emitting r2
            movl -12(%ebp), %edx
          movl -16(%ebp), %esi
          addl $4, %esp
          movl %esi, %eax
          cltd
          idivl %edx
          movl %eax, %esi
        movl %esi, -4(%ebp)
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
