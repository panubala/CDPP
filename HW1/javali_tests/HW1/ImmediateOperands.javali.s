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
        # Emitting i0 = 0
          # Emitting 0
          movl $0, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i0 = (5 + i0)
          # Emitting (5 + i0)
            # Emitting 5
            movl $5, %esi
            # Emitting i0
            movl -4(%ebp), %edi
          addl %edi, %esi
          # Emitting i0
          movl -4(%ebp), %edi
        movl %esi, -4(%ebp)
        # Emitting write(i0)
          # Emitting i0
          movl -4(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting i0 = (i0 + 5)
          # Emitting (i0 + 5)
            # Emitting i0
            movl -4(%ebp), %edi
            # Emitting 5
            movl $5, %esi
          addl %esi, %edi
          # Emitting i0
          movl -4(%ebp), %esi
        movl %edi, -4(%ebp)
        # Emitting write(i0)
          # Emitting i0
          movl -4(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting i0 = ((i0 + 5) + 3)
          # Emitting ((i0 + 5) + 3)
            # Emitting (i0 + 5)
              # Emitting i0
              movl -4(%ebp), %esi
              # Emitting 5
              movl $5, %edi
            addl %edi, %esi
            # Emitting 3
            movl $3, %edi
          addl %edi, %esi
          # Emitting i0
          movl -4(%ebp), %edi
        movl %esi, -4(%ebp)
        # Emitting write(i0)
          # Emitting i0
          movl -4(%ebp), %edi
        pushl %edi
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
