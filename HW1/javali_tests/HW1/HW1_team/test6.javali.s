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
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -4(%ebp), %edi
          # Emitting r1
          subl $4, %esp
        movl %edi, -8(%ebp)
        # Emitting write((5 + r1))
          # Emitting (5 + r1)
            # Emitting 5
            movl $5, %esi
            # Emitting r1
            movl -8(%ebp), %edi
          addl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting r1 = (r1 / (5 + r1))
          # Emitting (r1 / (5 + r1))
            # Emitting (5 + r1)
              # Emitting 5
              movl $5, %esi
              # Emitting r1
              movl -8(%ebp), %edi
            addl %edi, %esi
            # Emitting r1
            movl -8(%ebp), %edi
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
          # Emitting r1
          movl -8(%ebp), %esi
        movl %edi, -8(%ebp)
        # Emitting r2 = read()
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -12(%ebp), %esi
          # Emitting r2
          subl $4, %esp
        movl %esi, -16(%ebp)
        # Emitting r2 = (r2 / (r1 + 5))
          # Emitting (r2 / (r1 + 5))
            # Emitting (r1 + 5)
              # Emitting r1
              movl -8(%ebp), %edi
              # Emitting 5
              movl $5, %esi
            addl %esi, %edi
            # Emitting r2
            movl -16(%ebp), %esi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
          # Emitting r2
          movl -16(%ebp), %edi
        movl %esi, -16(%ebp)
        # Emitting r3 = 5
          # Emitting 5
          movl $5, %edi
          # Emitting r3
          subl $4, %esp
        movl %edi, -20(%ebp)
        # Emitting r3 = read()
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -24(%ebp), %esi
          # Emitting r3
          movl -20(%ebp), %edi
        movl %esi, -20(%ebp)
        # Emitting r3 = r1
          # Emitting r1
          movl -8(%ebp), %edi
          # Emitting r3
          movl -20(%ebp), %esi
        movl %edi, -20(%ebp)
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
