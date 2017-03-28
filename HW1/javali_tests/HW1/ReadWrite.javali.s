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
        # Emitting i0 = 5
          # Emitting 5
          movl $5, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i1 = read()
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -8(%ebp), %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -12(%ebp)
        # Emitting i1 = (i1 / (i1 + 4))
          # Emitting (i1 / (i1 + 4))
            # Emitting (i1 + 4)
              # Emitting i1
              movl -12(%ebp), %edi
              # Emitting 4
              movl $4, %esi
            addl %esi, %edi
            # Emitting i1
            movl -12(%ebp), %esi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
          # Emitting i1
          movl -12(%ebp), %edi
        movl %esi, -12(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -12(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting r1 = (i0 + i1)
          # Emitting (i0 + i1)
            # Emitting i0
            movl -4(%ebp), %edi
            # Emitting i1
            movl -12(%ebp), %esi
          addl %esi, %edi
          # Emitting r1
          subl $4, %esp
        movl %edi, -16(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -16(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write((r1 - 3))
          # Emitting (r1 - 3)
            # Emitting r1
            movl -16(%ebp), %esi
            # Emitting 3
            movl $3, %edi
          subl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
